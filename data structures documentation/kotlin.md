# kotlin data structures

<details>
<summary>Array</summary>

## Array
- It is used to store multiple values in a single variable.
- `arrayOf` function is used to create array, by placing the values in a comma separated list
```kotlin
val cars = arrayOf("first", "second", "third", "fourth")
```
### Access elements of array
- to access any element we can use index no inside square brackets
```kotlin
println(cars[0])
//Outputs first
```
### change array element
- use index to change array element
```kotlin
cars[0] = "ninth"
println(cars[0])
//outputs ninth
```
### Array length
- to count no of elements of array use `size` property
```kotlin
println(cars.size)
//Outputs 4
```

</details>