package com.sumel.jobsearch.api;

import com.sumel.jobsearch.model.JobPosition;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

/***
 * @Interface de base para las peticiones
 * que se hagan con Feign
 */
@Headers("Accept: application/json")
public interface APIJobs {

    @RequestLine("GET /positions.json")
    List<JobPosition> jobs(@QueryMap Map<String, Object> queryMap);
}
