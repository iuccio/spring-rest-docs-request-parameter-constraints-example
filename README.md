## Spring REST Docs – request parameter constraints example

Sample illustrating the use of a custom snippet template to document a request parameter's
constraints.

An extra column named `Constraints` is added to the table that documents the request
parameters by providing a custom template for the request parameters snippet. This custom
template can be found in
[`src/test/resources/org/springframework/restdocs/templates/request-parameters.snippet`][1].

The constraints are then described when documenting the request parameters by adding an
attribute named `constraints` to the parameter descriptor:

```java
this.mockMvc.perform(get("/?example=test"))
				.andExpect(status().isOk())
				.andExpect(content().string("TEST"))
				.andDo(document("example", requestParameters(
						parameterWithName("example").description("An example parameter")
						.attributes(key("constraints").value("Example constraints")))));
```

[1]: src/test/resources/org/springframework/restdocs/templates/request-parameters.snippet

### Generating the snippet

```
$ ./gradlew build
```

### Checking the output

```
$ cat build/generated-snippets/example/request-parameters.adoc
|===
|Parameter|Description|Constraints

|example
|An example parameter
|Example constraints

|===
```