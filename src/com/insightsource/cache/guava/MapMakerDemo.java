package com.insightsource.cache.guava;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.MapMaker;

public class MapMakerDemo
{
	public static void main(String args[])
	{
		ConcurrentMap<String, String> testMap = new MapMaker().concurrencyLevel(32).weakValues().makeMap();
		
		String a = "testaaa";
        testMap.put("a", a);
        testMap.put("b", "testb");

        System.out.println(testMap.get("a"));
        System.out.println(testMap.get("b"));
        System.out.println(testMap.get("c"));

        a = null;
        System.gc();
        
        /**
         * 这里sleep4秒钟过后，
         * 缓存都失效，再get就会根据绑定的function去获得value放在map中了。
         */
        try {
        	TimeUnit.SECONDS.sleep(2L);		//no work????
            //Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 看看这里的再输出，是不是就是新的值了！~
         */

        System.out.println(testMap.get("a"));
        System.out.println(testMap.get("b"));
        System.out.println(testMap.get("c"));
	}
}
