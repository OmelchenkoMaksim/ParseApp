Android Code Challenge

Overview
The goal is to write an Android app which queries an http address with a GET-request that returns
a JSON file. The response must be parsed and displayed in any kind of list view
(RecyclerView, LazyColumn etc).

Networking
The REST service (http://navvis.com/numbers.json) is still in development which means that you
have to develop/test the app with a local response until the service becomes available.

An example of the JSON response looks like this:

{
"numbers": [
4, 150, 12, 21, 136, 16, 3
]
}

Each number should be within the range 0...255 (1 Byte) and there can be an arbitrary amount of
numbers in the array.

Parsing
The numbers, i.e bytes in the array shall be parsed and each number shall be converted as follows:
• The two least significant bits determine the "section index"
• The most significant bit determines the "item checkmark"
• The intermediate bits determine the "item value"

The "section index" must be matched against a title as follows:
0 -> SECTION1
1 -> SECTION2
2 -> SECTION3
3 -> SECTION4

The "item value" must be matched against 6 titles like this:
0 -> Item1
1 -> Item2
2 -> Item3
3 -> Item4
4 -> Item5
5 -> Item6

The "item checkmark" bit sets a checkbox for each item:
0 -> unchecked
1 -> checked

An Example:

Value: 140 -> as binary representation 10001100b
"Section index" bits: 00 = 0 -> SECTION1
"Item value" bits: 00011 = 3 -> Item4
"Item checkmark" bit: 1 = 1 -> checked

Display & Layout
Each processed number shall be shown as an entry in a list. Items that share the same section
shall be grouped together under their section title. The section title entries and item title entries
must be sorted according to their value in ascending order, like in this example:

-----------------------
SECTION1
-----------------------
Item4 √
-----------------------
Item5
-----------------------
SECTION2
-----------------------
Item2 √
-----------------------

There is no need at all for a fancy layout, a plain list with basic entries.