package com.zealot.flume.statistics.service;

import com.zealot.flume.log.bean.StatisticsBean;

public interface StatisticsDataService {

	public void save(StatisticsBean info) throws Exception;
}
