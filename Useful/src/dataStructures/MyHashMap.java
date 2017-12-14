import java.util.LinkedList;
2
3
4 // Define the default hash-table size. Must be a power of 2
5 private static int DEFAULT_INITIAL_CAPACITY = 4;
6
7 // Define the maximum hash-table size. 1 << 30 is same as 2^30
8 private static int MAXIMUM_CAPACITY = 1 << 30;
9
10 // Current hash-table capacity. Capacity is a power of 2
11 private int capacity;
12
13 // Define default load factor
14 private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;
15
16 // Specify a load factor used in the hash table
17 private float loadFactorThreshold;
18
19 // The number of entries in the map
20 private int size = 0;
21
22 // Hash table is an array with each cell being a linked list
23 LinkedList<MyMap.Entry<K,V>>[] table;
24
25 /** Construct a map with the default capacity and load factor */
26
27 this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
28 }
29
30 /** Construct a map with the specified initial capacity and
31 * default load factor */
32
33 this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
34 }
35
36 /** Construct a map with the specified initial capacity
37 * and load factor */
38
39 if (initialCapacity > MAXIMUM_CAPACITY)
40 this.capacity = MAXIMUM_CAPACITY;
41 else
42 this.capacity = trimToPowerOf2(initialCapacity);
43
44 this.loadFactorThreshold = loadFactorThreshold;
45 table = new LinkedList[capacity];
46 }
47
48 @Override /** Remove all of the entries from this map */
49
50 size = 0;
public void clear() {
public MyHashMap(int initialCapacity, float loadFactorThreshold) {
public MyHashMap(int initialCapacity) {
public MyHashMap() {
public class MyHashMap<K, V> implements MyMap<K, V> { 


51 removeEntries();
52 }
53
54 @Override /** Return true if the specified key is in the map */
55
56 if (get(key) != null)
57 return true;
58 else
59 return false;
60 }
61
62 @Override /** Return true if this map contains the value */
63
64 for (int i = 0; i < capacity; i++) {
65 if (table[i] != null) {
66 LinkedList<Entry<K, V>> bucket = table[i];
67 for (Entry<K, V> entry: bucket)
68 if (entry.getValue().equals(value))
69 return true;
70 }
71 }
72
73 return false;
74 }
75
76 @Override /** Return a set of entries in the map */
77
78 java.util.Set<MyMap.Entry<K, V>> set =
79 new java.util.HashSet<MyMap.Entry<K, V>>();
80
81 for (int i = 0; i < capacity; i++) {
82 if (table[i] != null) {
83 LinkedList<Entry<K, V>> bucket = table[i];
84 for (Entry<K, V> entry: bucket)
85 set.add(entry);
86 }
87 }
88
89 return set;
90 }
91
92 @Override /** Return the value that matches the specified key */
93
94 int bucketIndex = hash(key.hashCode());
95 if (table[bucketIndex] != null) {
96 LinkedList<Entry<K, V>> bucket = table[bucketIndex];
97 for (Entry<K, V> entry: bucket)
98 if (entry.getKey().equals(key))
99 return entry.getValue();
100 }
101
102 return null;
103 }
104
105 @Override /** Return true if this map contains no entries */
106
107 return size == 0;
108 }
109
110 @Override /** Return a set consisting of the keys in this map */
public boolean isEmpty() {
public V get(K key) {
public java.util.Set<MyMap.Entry<K,V>> entrySet() {
public boolean containsValue(V value) {
containsKey public boolean containsKey(K key) {
containsValue
entrySet
get
isEmpty
28.7 Implementing a Map Using Hashing 1011
111
112 java.util.Set<K> set = new java.util.HashSet<K>();
113
114 for (int i = 0; i < capacity; i++) {
115 if (table[i] != null) {
116 LinkedList<Entry<K, V>> bucket = table[i];
117 for (Entry<K, V> entry: bucket)
118 set.add(entry.getKey());
119 }
120 }
121
122 return set;
123 }
124
125 @Override /** Add an entry (key, value) into the map */
126
127 if (get(key) != null) { // The key is already in the map
128 int bucketIndex = hash(key.hashCode());
129 LinkedList<Entry<K, V>> bucket = table[bucketIndex];
130 for (Entry<K, V> entry: bucket)
131 if (entry.getKey().equals(key)) {
132 V oldValue = entry.getValue();
133 // Replace old value with new value
134 entry.value = value;
135 // Return the old value for the key
136 return oldValue;
137 }
138 }
139
140 // Check load factor
141 if (size >= capacity * loadFactorThreshold) {
142 if (capacity == MAXIMUM_CAPACITY)
143 throw new RuntimeException("Exceeding maximum capacity");
144
145 rehash();
146 }
147
148 int bucketIndex = hash(key.hashCode());
149
150 // Create a linked list for the bucket if not already created
151 if (table[bucketIndex] == null) {
152 table[bucketIndex] = new LinkedList<Entry<K, V>>();
153 }
154
155 // Add a new entry (key, value) to hashTable[index]
156 table[bucketIndex].add(new MyMap.Entry<K, V>(key, value));
157
158 size++; // Increase size
159
160 return value;
161 }
162
163 @Override /** Remove the entries for the specified key */
164
165 int bucketIndex = hash(key.hashCode());
166
167 // Remove the first entry that matches the key from a bucket
168 if (table[bucketIndex] != null) {
169 LinkedList<Entry<K, V>> bucket = table[bucketIndex];
170 for (Entry<K, V> entry: bucket)
public void remove(K key) {
public V put(K key, V value) {
public java.util.Set<K> keySet() { keySet
put
remove
1012 Chapter 28 Hashing
171 if (entry.getKey().equals(key)) {
172 bucket.remove(entry);
173 size—–; // Decrease size
174 break; // Remove just one entry that matches the key
175 }
176 }
177 }
178
179 @Override /** Return the number of entries in this map */
180
181 return size;
182 }
183
184 @Override /** Return a set consisting of the values in this map */
185
186 java.util.Set<V> set = new java.util.HashSet<V>();
187
188 for (int i = 0; i < capacity; i++) {
189 if (table[i] != null) {
190 LinkedList<Entry<K, V>> bucket = table[i];
191 for (Entry<K, V> entry: bucket)
192 set.add(entry.getValue());
193 }
194 }
195
196 return set;
197 }
198
199 /** Hash function */
200
201 return supplementalHash(hashCode) & (capacity - 1);
202 }
203
204 /** Ensure the hashing is evenly distributed */
205
206 h ^= (h >>> 20) ^ (h >>> 12);
207 return h ^ (h >>> 7) ^ (h >>> 4);
208 }
209
210 /** Return a power of 2 for initialCapacity */
211
212 int capacity = 1;
213 while (capacity < initialCapacity) {
214 capacity <<= 1; // Same as capacity *= 2. <= is more efficient
215 }
216
217 return capacity;
218 }
219
220 /** Remove all entries from each bucket */
221
222 for (int i = 0; i < capacity; i++) {
223 if (table[i] != null) {
224 table[i].clear();
225 }
226 }
227 }
228
229 /** Rehash the map */
230 private void rehash() {
private void removeEntries() {
private int trimToPowerOf2(int initialCapacity) {
private static int supplementalHash(int h) {
private int hash(int hashCode) {
public java.util.Set<V> values() {
size public int size() {
values
hash
supplementalHash
trimToPowerOf2
removeEntries
rehash
28.7 Implementing a Map Using Hashing 1013
231 java.util.Set<Entry<K, V>> set = entrySet(); // Get entries
232 capacity <<= 1; // Same as capacity *= 2. <= is more efficient
233 table = new LinkedList[capacity]; // Create a new hash table
234 size = 0; // Reset size to 0
235
236 for (Entry<K, V> entry: set) {
237 put(entry.getKey(), entry.getValue()); // Store to new table
238 }
239 }
240
241 @Override /** Return a string representation for this map */
242
243 StringBuilder builder = new StringBuilder("[");
244
245 for (int i = 0; i < capacity; i++) {
246 if (table[i] != null && table[i].size() > 0)
247 for (Entry<K, V> entry: table[i])
248 builder.append(entry);
249 }
250
251 builder.append("]");
252 return builder.toString();
253 }
254 }