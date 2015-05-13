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

public class Sample2 {
	public static void main(String[] args) {
		
		Set<Integer> unique = new HashSet<Integer>();
		// Index for Configuration
		IndexedCollection<Conf> configs = new ConcurrentIndexedCollection<Conf>();
		configs.addIndex(NavigableIndex.onAttribute(Conf.CONF_ID));
		configs.addIndex(HashIndex.onAttribute(Conf.CT_ID));
		configs.addIndex(HashIndex.onAttribute(Conf.CT_VAL));

		// Dummy Data
		Random randomGenerator = new Random();
		for (int i = 0; i < 5000000; i++) {
			configs.add(new Conf(i, randomGenerator.nextInt(10),
					randomGenerator.nextInt(30)));
		}
		configs.add(new Conf(10001, 2,
				23));
	
		System.out.println(configs.size());
		// Query
		Query<Conf> query1 = and(equal(Conf.CT_ID, 2),
				equal(Conf.CT_VAL, 23));
		long starttime = System.currentTimeMillis();
		ResultSet<Conf> rs = configs.retrieve(query1);
		for (Conf c : rs) {
//			System.out.println(c.toString());
			unique.add(c.conf_id);
		}
		long endtime = System.currentTimeMillis();
		System.out.println("TotalTime"+(endtime-starttime));
		System.out.println("");
		



	}

}
