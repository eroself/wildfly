/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2016, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.clustering.controller;

import java.util.Collections;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import org.jboss.as.controller.OperationStepHandler;
import org.jboss.dmr.ModelNode;

/**
 * @author Paul Ferraro
 */
public interface OperationStepHandlerDescriptor {

    /**
     * The capabilities provided by this resource, paired with the condition under which they should be [un]registered
     * @return a map of capabilities to predicates
     */
    default Map<Capability, Predicate<ModelNode>> getCapabilities() {
        return Collections.emptyMap();
    }

    /**
     * Returns a transformer to be applied to all operations that operate on an existing resource.
     * This is typically used to adapt legacy operations to conform to the current version of the model.
     * @return an operation handler transformer.
     */
    default UnaryOperator<OperationStepHandler> getOperationTransformation() {
        return UnaryOperator.identity();
    }
}
