package org.example;

import org.apache.kafka.common.message.CreateTopicsRequestData;
import org.apache.kafka.common.message.RequestHeaderData;

import io.kroxylicious.proxy.filter.CreateTopicsRequestFilter;
import io.kroxylicious.proxy.filter.KrpcFilterContext;

public class SampleFilter implements CreateTopicsRequestFilter {
    @Override
    public void onCreateTopicsRequest(RequestHeaderData header, CreateTopicsRequestData request, KrpcFilterContext context) {

    }
}
