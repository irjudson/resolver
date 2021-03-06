package com.sensorberg.front.resolve.resources.index

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.annotation.Resource

/**
 * index resource
 */
@RestController
class IndexResource {

    @Resource
    IndexService indexService

    @Resource
    SynchronizationService synchronizationService

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    def recentLogs(@RequestParam(value = "key", required = false) String key) {
        synchronizationService.recentLogs()
    }

    @RequestMapping(value = "/index", method = RequestMethod.PUT)
    def synchronize(@RequestParam(value = "key", required = false) String key) {
        synchronizationService.synchronize()
    }

    @RequestMapping(value = "/index", method = RequestMethod.DELETE)
    def reset(@RequestParam(value = "key", required = false) String key) {
        indexService.reset()
        return [success: true]
    }

}