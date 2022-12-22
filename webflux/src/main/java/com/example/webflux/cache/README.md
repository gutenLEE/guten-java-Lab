### [Web on Reactive Stack](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html)

---

(버전 2.6.7)  
### 웹플럭스에서 @Cacheable 사용시 문제점
- 논블로킹을 지원하는 캐시 구현체 없음
### How to solve? 
- 실제 값이 아닌 Mono 와 Flux 의 wrapper 오브젝트를 캐싱하는 방법




---
### Reference  
[Spring Webflux and @Cacheable Annotation](https://www.baeldung.com/spring-webflux-cacheable)
