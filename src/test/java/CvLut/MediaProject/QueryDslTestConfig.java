package CvLut.MediaProject;

import CvLut.MediaProject.repository.feature.FeatureQueryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@TestConfiguration
public class QueryDslTestConfig {
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory(){
        return new JPAQueryFactory(entityManager);
    }

//    @Bean
//    public FeatureQueryRepository featureQueryRepository(){
//        return new FeatureQueryRepository(jpaQueryFactory());
//    }
}
