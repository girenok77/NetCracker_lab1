package analyzer;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import sorters.Sorting;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Girenok
 * This class ganerate statistic aboout speed of sorting by different methods
 * {@link sorters.QuickSort}
 * {@link sorters.MergeSort}
 * {@link sorters.ArraysSortImpl}
 * {@link sorters.BubbleDownSort }
 * {@link sorters.BubbleUpSort}
 */
public class Stat {
    private int max_arr_size;
    private HashMap<String, HashMap<String, Long>>result;
    public Stat(int max_arr_size){
        this.max_arr_size=max_arr_size;
        doStat();
    }


    private void doStat() {
        result=new HashMap<String, HashMap<String, Long>>();
        Set<Method> methods=getMethods();

        Set<Class<? extends sorters.Sorting>> s = getClasses();
        HashMap<String,Long>SortResultMap=new HashMap<String, Long>();

        for (Method m : methods) {
            for (Class clazz : s) {

                long workTime = 0;
                try {
                    int []arr=(int[])m.invoke(m.getClass(),max_arr_size);
                    long startTime = System.nanoTime();
                    clazz.getDeclaredConstructor(arr.getClass()).newInstance(arr);
                    long endTime = System.nanoTime();
                    workTime = endTime - startTime;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
                SortResultMap.put(clazz.getSimpleName(),workTime);
                //System.out.println(clazz.getSimpleName() + " do sorting for " + m.getName() + " to " + workTime/1000000+ "ms");
            }
            result.put(m.getName(),SortResultMap);
        }


    }

    //work with Reflection
    private Set<Class<? extends Sorting>> getClasses() {
        Set<Class<? extends sorters.Sorting>> s=(new Reflections("sorters")).getSubTypesOf(Sorting.class);
        Iterator<Class<? extends Sorting>> iterator=s.iterator();
        while (iterator.hasNext()){
            if(Modifier.isAbstract(iterator.next().getModifiers())){
                iterator.remove();
            }
        }

        return s;
    }

    private Set<Method> getMethods() {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath())
                .setScanners(new MethodAnnotationsScanner()));

        return reflections.getMethodsAnnotatedWith(fillers.filler.class);
    }

    /**
     *@return HasMap where keys is method of sorting and
     * values is time characteristics
     */
    public HashMap<String, HashMap<String, Long>> getResult() {
        return result;
    }
}
