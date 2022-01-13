package org.datausagetracing.integration.common.usage

import com.fasterxml.jackson.annotation.JsonAnyGetter

data class CauseImpl(
    @get:JsonAnyGetter val map: Map<String, Any>
) : Cause, Map<String, Any> by map {
    override fun merge(other: Cause): Cause = CauseImpl(this + other)
}