package com.netapp.cqengine1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.index.hash.HashIndex;
import com.googlecode.cqengine.index.navigable.NavigableIndex;
import com.googlecode.cqengine.query.Query;
import com.googlecode.cqengine.resultset.ResultSet;

import static com.googlecode.cqengine.query.QueryFactory.*;

public class Sample3 {
	public static void main(String[] args) {
		
		Set<Integer> unique = new HashSet<Integer>();
		// Index for Configuration
		IndexedCollection<Configuration1> configs = new ConcurrentIndexedCollection<Configuration1>();
		configs.addIndex(NavigableIndex.onAttribute(Configuration1.NAME));
		configs.addIndex(HashIndex.onAttribute(Configuration1.CT_ID));
		configs.addIndex(HashIndex.onAttribute(Configuration1.C_VALUES));

		// Dummy Data
		Random randomGenerator = new Random();
		for (int i = 0; i < 500000; i++) {
			
			configs.add(new Configuration1(i, randomGenerator.nextInt(10),
					Arrays.asList(randomGenerator.nextInt(30),randomGenerator.nextInt(30),randomGenerator.nextInt(30),randomGenerator.nextInt(30),randomGenerator.nextInt(30),randomGenerator.nextInt(30))));
		}
		
	
		System.out.println(configs.size());
		// Query
		Query<Configuration1> query1 = and(equal(Configuration1.CT_ID, 2),
				in(Configuration1.C_VALUES, 23,25));
		long starttime = System.currentTimeMillis();
		ResultSet<Configuration1> rs = configs.retrieve(query1);
		for (Configuration1 c : rs) {
//			System.out.println(c.toString());
			unique.add(c.name);
		}
		long endtime = System.currentTimeMillis();
		System.out.println("TotalTime"+(endtime-starttime));
//		for (int c : unique){
//			System.out.println(c);
//		}
//		



	}

}
