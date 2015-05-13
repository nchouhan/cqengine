package com.netapp.cqengine1;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.MultiValueAttribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;

public class Configuration {
	public static final Attribute<Configuration, String> NAME = new SimpleAttribute<Configuration, String>("name") {
        public String getValue(Configuration conf, QueryOptions queryOptions) { return conf.name; }
    };
    
    public static final Attribute<Configuration, CT> CTS = new MultiValueAttribute<Configuration, CT>("cts") {
        public List<CT> getValues(Configuration conf, QueryOptions queryOptions) { return conf.cts; }
    };
	
//	public static String NAME = "name";
//	public static String CTS = "cts";
	String name;
	@Override
	public String toString() {
		return "Configuration [name=" + name + ", cts=" + cts + "]";
	}

	List<CT> cts = new ArrayList<CT>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CT> getCts() {
		return cts;
	}

	public void setCts(List<CT> cts) {
		this.cts = cts;
	}

	public Configuration(String name, List<CT> cts) {
		super();
		this.name = name;
		this.cts = cts;
	}
}
