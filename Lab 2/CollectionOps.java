import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.*;

public class CollectionOps {

    // Put your code for print here ...
	public static <T> void print(Collection<T> l) {
		Iterator<T> it = l.iterator();
		String s = "[";
		while(it.hasNext()){
			s+= it.next().toString();
			if(it.hasNext())
				s += ",";
		}
			s += "]";
		System.out.println(s);
	}



    // Put your code for reverse here ...

    // Put your code for less here ...

    // Example
    public static <T,R> Collection<R>
    map(Function<T,R> f,Collection<T> c)
    {
        // Determine the dynamic type of the collection
        Class<? extends Collection> cls = c.getClass();
        try {
            // Create an object of the same dynamic type as c
            Collection<R> result = (Collection<R>)cls.newInstance();
            // type.cast(type.newInstance());
            // Copy the elements and apply op to them
            for ( T x : c )
                result.add(f.apply(x));
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Put your code for filter here ...

}
