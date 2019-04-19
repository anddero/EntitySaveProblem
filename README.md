# EntitySaveProblem
Testing whether a recently saved `@Entity` object can be modified
without explicitly calling `CrudRepository.save()` on it, while **Open-Session-In-View** is enabled.

1. Run the Spring Boot `CarServiceApp` application.
2. Open database at [localhost:8888/h2-console/](http://localhost:8888/h2-console/) from your browser.
    * JDBC URL: `jdbc:h2:mem:debugdb`
    * User Name: `test`
    * Password: `z`
3. Run the request in `requests.http` file or simply open [localhost:8888/resource](http://localhost:8888/resource) in your browser.
4. In the database view the `CAR_TBL` table.
    * You can run the query: `SELECT * FROM CAR_TBL`.
    * You can see that the `CAR_NAME` is `VolksWagen`, though it should be `Audi`, which means changes are not automatically flushed.
5. Introduce the statement `carRepo.save(car)` into `CarController`'s only method and repeat the above steps 1-4 to see that **it works properly, giving `Audi`**.
