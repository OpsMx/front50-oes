/*
 * Copyright 2021 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.netflix.spinnaker.front50.api.model.pipeline;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.netflix.spinnaker.front50.api.model.Timestamped;
import com.netflix.spinnaker.kork.artifacts.model.ExpectedArtifact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pipeline implements Timestamped {

  public static final String TYPE_TEMPLATED = "templatedPipeline";

  private Map<String, Object> anyMap = new HashMap<>();

  private Map<String, Object> appConfig = new HashMap<>();

  @Setter private String id;
  @Getter @Setter private String name;
  @Getter @Setter private String application;

  @Getter @Setter private String description;

  @Getter @Setter private String type;

  @Setter private String schema;

  @Getter @Setter private Object config;

  @Getter @Setter private List<Trigger> triggers = new ArrayList<>();

  @Getter @Setter private List<ExpectedArtifact> expectedArtifacts = new ArrayList<>();

  @Getter @Setter private Map<String, Object> locked;

  @Getter @Setter private Integer index;

  private String createTs;
  private String updateTs;
  private String lastModifiedBy;

  @JsonIgnore @Getter @Setter private Long lastModified;

  @Getter @Setter private String email;

  @Getter @Setter private Boolean disabled;

  @Getter @Setter private Map<String, Object> template;

  @Getter @Setter private List<String> roles;

  @Getter @Setter private String serviceAccount;

  @Getter @Setter private String executionEngine;

  @Getter @Setter private Integer stageCounter;

  @Getter @Setter private List<Map<String, Object>> stages;

  @Getter @Setter private Map<String, Object> constraints;

  @Getter @Setter private Map<String, Object> payloadConstraints;

  @Getter @Setter private Boolean keepWaitingPipelines;
  @Getter @Setter private Boolean limitConcurrent;

  @Getter @Setter private Integer maxConcurrentExecutions;

  @Getter @Setter private List<Map<String, Object>> parameterConfig;

  @Getter @Setter private List<Map<String, Object>> notifications;

  @Getter @Setter private String spelEvaluator;

  @Getter @Setter private Map<String, Object> variables = new HashMap<>();

  @Getter @Setter private List<Object> exclude;

  @Getter @Setter private Boolean regenerateCronTriggerIds;

  public String getUpdateTs() {
    var lastModified = getLastModified();

    return lastModified != null ? lastModified.toString() : null;
  }

  public void setAny(String key, Object value) {
    anyMap.put(key, value);
  }

  public Map<String, Object> getAny() {
    return anyMap;
  }

  public void setAppConfig(String key, Object value) {
    appConfig.put(key, value);
  }

  public Map<String, Object> getAppConfig() {
    return appConfig;
  }

  @Override
  public String getId() {
    return this.id;
  }

  @Override
  public String getLastModifiedBy() {
    return this.lastModifiedBy;
  }

  @Override
  public void setLastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }

  /**
   * Denotes templated pipeline config schema version.
   *
   * @return
   */
  public String getSchema() {
    final String get = this.schema;
    if (get == null || get == "") {
      return "1";
    }
    return get;
  }
}
