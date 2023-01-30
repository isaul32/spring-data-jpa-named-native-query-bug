package com.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private DemoRepository demoRepository;

	@Autowired
	private EntityManager entityManager;

	@Test
	@Transactional
	void testNamedNativeQueries1() {
		Demo entity = new Demo();
		entityManager.persist(entity);
		assertNotNull(entity.getId());

		Query query = entityManager.createNamedQuery("Demo.findAllCustom");
		List<DemoPojo> resultList = query.getResultList();
		assertEquals(1, resultList.size());
	}

	@Test
	@Transactional
	void testNamedNativeQueries2() {
		Demo entity = new Demo();
		entityManager.persist(entity);
		assertNotNull(entity.getId());

		Query query = entityManager.createNamedQuery("Demo.findAllCustom", DemoPojo.class);
		List<DemoPojo> resultList = query.getResultList();
		assertEquals(1, resultList.size());
	}

	@Test
	@Transactional
	void testNamedNativeQueries3() {
		Demo entity = new Demo();
		entityManager.persist(entity);
		assertNotNull(entity.getId());

		Query query = entityManager.createNamedQuery("Demo.findAllCustom", Tuple.class);
		List<DemoPojo> resultList = query.getResultList();
		assertEquals(1, resultList.size());
	}

	@Test
	@Transactional
	void testNamedNativeQueries4() {
		Demo entity = new Demo();
		demoRepository.save(entity);
		List<DemoPojo> custom = demoRepository.findAllCustom();
		assertEquals(1, custom.size());
	}
}
