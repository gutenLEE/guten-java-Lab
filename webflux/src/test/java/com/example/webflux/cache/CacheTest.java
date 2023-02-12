//package com.example.webflux.cache;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.testcontainers.containers.MongoDBContainer;
//import org.testcontainers.utility.DockerImageName;
//import reactor.core.publisher.Mono;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
///**
// * @author gutenlee
// * @since 2022/12/22
// */
//@SpringBootTest
//public class CacheTest {
//    @Autowired
//    private ItemService itemService;
//    final static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.0.10"));
//
//    @DynamicPropertySource
//    static void mongoDbProperties(DynamicPropertyRegistry registry) {
//        mongoDBContainer.start();
//        registry.add("spring.data.mongodb.uri",  mongoDBContainer::getReplicaSetUrl);
//    }
//
//    @Test
//    public void givenItem_whenGetItemIsCalled_thenMonoIsCached() {
//        Mono<Item> glass = itemService.save(new Item("glass", 1.00));
//
//        String id = glass.block().get_id();
//
//        Mono<Item> mono = itemService.getItem(id);
//        Item item = mono.block();
//
//        assertThat(item).isNotNull();
//        assertThat(item.getName()).isEqualTo("glass");
//        assertThat(item.getPrice()).isEqualTo(1.00);
//
//        Mono<Item> mono2 = itemService.getItem(id);
//        Item item2 = mono2.block();
//
//        assertThat(item2).isNotNull();
//        assertThat(item2.getName()).isEqualTo("glass");
//        assertThat(item2.getPrice()).isEqualTo(1.00);
//    }
//}
