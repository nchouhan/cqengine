package com.netapp.cqengine1;

import java.util.Arrays;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.index.hash.HashIndex;
import com.googlecode.cqengine.index.navigable.NavigableIndex;
import com.googlecode.cqengine.query.Query;
import com.googlecode.cqengine.resultset.ResultSet;

import static com.googlecode.cqengine.query.QueryFactory.*;

public class Sample1 {
	public static void main(String[] args) {
		//Index for Configuration
		IndexedCollection<Configuration> configs = new ConcurrentIndexedCollection<Configuration>();
		configs.addIndex(NavigableIndex.onAttribute(Configuration.NAME));
		configs.addIndex(HashIndex.onAttribute(Configuration.CTS));
		//Index for Component Type
		IndexedCollection<CT> cts = new ConcurrentIndexedCollection<CT>();
		cts.addIndex(NavigableIndex.onAttribute(CT.CT_ID));
		cts.addIndex(HashIndex.onAttribute(CT.C_IDS));
		//Dummy Data 
		configs.add(new Configuration("123", Arrays.asList(new CT(1,Arrays.asList(1,2,3,4)), new CT(2, Arrays.asList(5,6,7,8)))));
		configs.add(new Configuration("124", Arrays.asList(new CT(1,Arrays.asList(3,4)), new CT(2, Arrays.asList(5,8)))));
		configs.add(new Configuration("125", Arrays.asList(new CT(1,Arrays.asList(4,9)), new CT(2, Arrays.asList(5,6,7,8,10)))));
		configs.add(new Configuration("126", Arrays.asList(new CT(1,Arrays.asList(21,22,23,4)), new CT(2, Arrays.asList(35,46,47,58)))));
		//Query
		Query<Configuration> query1 = or(startsWith(Configuration.NAME, "123"), equal(Configuration.NAME,"123"));
		
		ResultSet<Configuration> rs = configs.retrieve(query1);
		for (Configuration c : rs){
			System.out.println(c.toString());
		}
		
		
	}

}
