/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qihoo.qsql.org.apache.calcite.rel.stream;

import com.qihoo.qsql.org.apache.calcite.plan.Convention;
import com.qihoo.qsql.org.apache.calcite.plan.RelOptCluster;
import com.qihoo.qsql.org.apache.calcite.plan.RelTraitSet;
import com.qihoo.qsql.org.apache.calcite.rel.RelInput;
import com.qihoo.qsql.org.apache.calcite.rel.RelNode;

import java.util.List;

/**
 * Sub-class of {@link com.qihoo.qsql.org.apache.calcite.rel.stream.Delta}
 * not targeted at any particular engine or calling convention.
 */
public final class LogicalDelta extends Delta {
  /**
   * Creates a LogicalDelta.
   *
   * <p>Use {@link #create} unless you know what you're doing.
   *
   * @param cluster   Cluster that this relational expression belongs to
   * @param input     Input relational expression
   */
  public LogicalDelta(RelOptCluster cluster, RelTraitSet traits,
      RelNode input) {
    super(cluster, traits, input);
  }

  /** Creates a LogicalDelta by parsing serialized output. */
  public LogicalDelta(RelInput input) {
    super(input);
  }

  /** Creates a LogicalDelta. */
  public static LogicalDelta create(RelNode input) {
    final RelTraitSet traitSet = input.getTraitSet().replace(Convention.NONE);
    return new LogicalDelta(input.getCluster(), traitSet, input);
  }

  @Override public RelNode copy(RelTraitSet traitSet, List<RelNode> inputs) {
    return new LogicalDelta(getCluster(), traitSet, sole(inputs));
  }
}

// End LogicalDelta.java
