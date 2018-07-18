package com.qg.dao;

import java.util.List;

import com.qg.bean.Mobile;

public interface MobileDao {
	void saveMobile(Mobile mobile);
	
	void saveMobileBatch(List<Mobile> mobile);
}
