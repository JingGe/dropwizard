Simple dropwizard application only for showing how health check works 
=======================
Time metric of the RESTful API
-----------------------
@Timed has been added in front of the method BookResource#getBook(int id).
Jersey resources class annotated with this annotation will be instrumented by Metrics (please take a look at http://metrics.codahale.com/manual/jersey/) and following values will be measured or calculated:

> com.jingge.demo.msa.book.resources.BookResource.getBook: {

> count: 0,

> max: 0,

> mean: 0,

> min: 0,

> p50: 0,

> p75: 0,

> p95: 0,

> p98: 0,

> p99: 0,

> p999: 0,

> stddev: 0,

> m15_rate: 0,

> m1_rate: 0,

> m5_rate: 0,

> mean_rate: 0,

> duration_units: "seconds",

> rate_units: "calls/second"

> }

These values can be found when you point the web browser to http://localhost:8081/metrics.
To make sure some rational values will be shown, the BookResource#getBook(int id) has been slow down in purpose.

---------------------------
Create you own health check
---------------------------
It is also possible to implement you own health check by reating a new class that extends com.codahale.metrics.health.HealthCheck.
The class com.jingge.demo.msa.book.health.SimpleHealthCheck shows you an example, where the OperatingSystemMXBean (which itself is another interesting story, please see http://sellmic.com/blog/2011/07/21/hidden-java-7-features-cpu-load-monitoring/) from JDK 1.7 is used to figure out some OS information at the hardware level.
The minMemory is configured in the config.yml and injected into SimpleHealthCheck in App class.

-----------------
Try yourself
-----------------

**Time metric**

1. Remove @Timed, run the application and take a look at http://localhost:8081/metrics
2. add @Timed, run the application and take a look at http://localhost:8081/metrics. A new metric under timers is shown for com.jingge.demo.msa.book.resources.BookResource.getBook.

**health check**

1. change the minMemory in config.yml to 3, run the application and take a look at http://localhost:8081/healthcheck.
2. change the minMemory in config.yml to 16 (assume you have a memory smaller than 16G), run the application and take a look at http://localhost:8081/heanlthcheck.

