# [Defining Relationship](https://mermaid.js.org/syntax/classDiagram.html)

- 표기법 [classA][Arrow][ClassB]

```mermaid
classDiagram
classA --|> classB : Inheritance
classC --* classD : Composition
classE --o classF : Aggregation
classG --> classH : Association
classI -- classJ : Link(Solid)
classK ..> classL : Dependency
classM ..|> classN : Realization
classO .. classP : Link(Dashed)
```
- <|--	Inheritance
- \*--	Composition
- o--	Aggregation
- -->	Association
- --	Link (Solid)
- ..>	Dependency
- ..|>	Realization
- ..	Link (Dashed)