package io.musinsa.searchplatformkafkaproducer.vo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SearchPlatformTopicTemplate<T> {
    private String id;
    private String sentDate;
    private String updateDate;
    private String topic;
    private String eventType;
    private String version;
    private String clusterName;
    private String aliasName;
    private T payload;
    private String useWriteAliasYN;
}
