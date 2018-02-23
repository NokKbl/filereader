# filereader
by Kunyaruk Katebunlu 6010545692

Result of runtime for reading AliceInWonderland.txt (52,539 chars)

Task													| Time
-----------------------------------------------------	| ------------
Read by InputStreamReader, append to String			| 0.879788 sec
Read by InputStreamReader, append to StringBuilder	| 0.003533 sec
Read by BufferReader, append lines to String			| 0.031988 sec

## Explanation of Results
- **Read String and StringBuilder by same Reader (InputStreamReader)**

Append to String is **slower than** append to StringBuilder because 
String is immutable object so it always generates a new String and discard the older String but 
StringBuilder is mutable object and it can append the String.

- **Read same String but different Reader (InputStreamReader vs BufferedReader)**

Read String by BufferedReader is **faster than** InputStreamReader because
BufferedReader read line by line of data from the stream but 
InputStreamReader read only one character from the stream.