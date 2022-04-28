//package com.compilit.fluentj.springjpa.api;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Predicate;
//
//class CrudOperationsUsageTests {
//
//  private final CrudRepository<TestObject, String> repository = Mockito.mock(CrudRepository.class);
//  private final List<Predicate<TestObject>> rules = new ArrayList<>();
//
//  @Test
//  void createUseCase_shouldReturnResponse() {
//    var id = "12345";
//    var testObject = new TestObject(id);
//    Mockito.when(repository.save(Mockito.any())).thenAnswer(x -> testObject);
//    var result = CrudOperations.create(new TestObject()).in(repository).afterValidating(rules).andReturn(TestObject::getId);
//    Assertions.assertThat(result).isEqualTo(id);
//  }
//
//  @Test
//  void readUseCase_shouldReturnResponse() {
//    var id = "12345";
//    var testObject = new TestObject(id);
//    Mockito.when(repository.save(Mockito.any())).thenAnswer(x -> testObject);
////    var result = CrudOperations.findById(id).in(repository.);
//    Assertions.assertThat(result).isEqualTo(id);
//  }
//
//  @Test
//  void updateUseCase_shouldReturnResponse() {
//
//  }
//
//  @Test
//  void deleteUseCase_shouldReturnResponse() {
//
//  }
//}
