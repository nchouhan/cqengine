package com.netapp.cqengine1;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.MultiValueAttribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;

public class Configuration1 {
	
	
	public Configuration1(int name, int ct_id, List<Integer> c_values) {
		super();
		this.name = name;
		this.ct_id = ct_id;
		this.c_values = c_values;
	}

	@Override
	public String toString() {
		return "Configuration1 [name=" + name + ", ct_id=" + ct_id
				+ ", c_values=" + c_values + "]";
	}

	public static final Attribute<Configuration1, Integer> NAME = new SimpleAttribute<Configuration1, Integer>(
			"name") {
		public Integer getValue(Configuration1 conf, QueryOptions queryOptions) {
			return conf.name;
		}
	};
	public static final Attribute<Configuration1, Integer> CT_ID = new SimpleAttribute<Configuration1, Integer>(
			"name") {
		public Integer getValue(Configuration1 conf, QueryOptions queryOptions) {
			return conf.ct_id;
		}
	};

	public static final Attribute<Configuration1, Integer> C_VALUES = new MultiValueAttribute<Configuration1, Integer>(
			"c_values") {
		public List<Integer> getValues(Configuration1 conf,
				QueryOptions queryOptions) {
			return conf.c_values;
		}
	};

	public List<Integer> getC_values() {
		return c_values;
	}

	public void setC_values(List<Integer> c_values) {
		this.c_values = c_values;
	}

	int name;
	int ct_id;

	public int getCt_id() {
		return ct_id;
	}

	public void setCt_id(int ct_id) {
		this.ct_id = ct_id;
	}

	List<Integer> c_values = new ArrayList<Integer>();

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

}
