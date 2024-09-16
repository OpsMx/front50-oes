/*
 * Copyright 2018 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.netflix.spinnaker.front50.model.pipeline;

import com.netflix.spinnaker.front50.api.model.pipeline.Trigger;
import com.netflix.spinnaker.kork.artifacts.model.Artifact;
import com.netflix.spinnaker.kork.artifacts.model.ExpectedArtifact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class V2TemplateConfiguration {
  private String schema;
  private String application;
  private String name;
  private Artifact template;

  private Map<String, Object> appConfig = new HashMap<>();

  private String type;

  private List<Trigger> triggers = new ArrayList<>();

  private List<ExpectedArtifact> expectedArtifacts = new ArrayList<>();

  private Map<String, Object> any = new HashMap<>();

  private String description;

  private Object config;

  private Integer index;

  private Long lastModified;

  private String email;

  private Boolean disabled;

  private List<String> roles;

  private String serviceAccount;

  private String executionEngine;

  private Integer stageCounter;

  private List<Map<String, Object>> stages;

  private Map<String, Object> constraints;

  private Map<String, Object> payloadConstraints;

  private Boolean keepWaitingPipelines;

  private Boolean limitConcurrent;

  private Integer maxConcurrentExecutions;

  private List<Map<String, Object>> parameterConfig;

  private List<Map<String, Object>> notifications;

  private String spelEvaluator;

  private Map<String, Object> variables = new HashMap<>();

  private String createTs;

  private String updateTs;

  private String lastModifiedBy;

  private List<Object> exclude;

  private String id;
}
