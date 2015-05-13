package com.netapp.cqengine1;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;

public class Config {
int conf_id;
int ct_id;
int ct_val;

public Config(int conf_id, int ct_id, int ct_val) {
	super();
	this.conf_id = conf_id;
	this.ct_id = ct_id;
	this.ct_val = ct_val;
}
@Override
public String toString() {
	return "Conf [conf_id=" + conf_id + ", ct_id=" + ct_id + ", ct_val="
			+ ct_val + "]";
}
public static final Attribute<Config, Integer> CT_ID = new SimpleAttribute<Config, Integer>("ct_id") {
    public Integer getValue(Config conf, QueryOptions queryOptions) { return conf.ct_id; }
};
public static final Attribute<Config, Integer> CT_VAL = new SimpleAttribute<Config, Integer>("ct_val") {
    public Integer getValue(Config conf, QueryOptions queryOptions) { return conf.ct_val; }
};
public static final Attribute<Config, Integer> CONF_ID = new SimpleAttribute<Config, Integer>("conf_id") {
    public Integer getValue(Config conf, QueryOptions queryOptions) { return conf.ct_val; }
};

public int getConf_id() {
	return conf_id;
}
public void setConf_id(int conf_id) {
	this.conf_id = conf_id;
}
public int getCt_id() {
	return ct_id;
}
public void setCt_id(int ct_id) {
	this.ct_id = ct_id;
}
public int getCt_val() {
	return ct_val;
}
public void setCt_val(int ct_val) {
	this.ct_val = ct_val;
}
}
