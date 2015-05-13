package com.netapp.cqengine1;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.MultiValueAttribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;

public class CT {
	
	public static final Attribute<CT, Integer> CT_ID = new SimpleAttribute<CT, Integer>("ct_id") {
        public Integer getValue(CT conf, QueryOptions queryOptions) { return conf.ct_id; }
    };
    
    public static final Attribute<CT, Integer> C_IDS = new MultiValueAttribute<CT, Integer>("c_ids") {
        public List<Integer> getValues(CT conf, QueryOptions queryOptions) { return conf.c_ids; }
    };
	
	
//	public static String C_IDS = "c_ids";
//	public static String CT_ID = "ct_id";

	

	

	public int getCt_id() {
		return ct_id;
	}

	public CT(int ct_id, List<Integer> c_ids) {
		super();
		this.ct_id = ct_id;
		this.c_ids = c_ids;
	}

	public void setCt_id(int ct_id) {
		this.ct_id = ct_id;
	}

	public List<Integer> getC_ids() {
		return c_ids;
	}

	public void setC_ids(List<Integer> c_ids) {
		this.c_ids = c_ids;
	}

	int ct_id;
	List<Integer> c_ids = new ArrayList<Integer>();
}
