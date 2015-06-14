# tuple-counts

Data structure and API for summarizing the occurrences of event tuples.

## Usage

## Structure
Incoming tuples of the form `[action subject object timestamp]` are summarized into a nested data structure

```
{ subject
     { action
          { object [count timestamp] }
     }
} 
```

Where `count` is the count of occurrences so far and `timestamp` is the timestamp of the last recorded event.

## API
A Java interface is provided for the API, to support interoperability.

| Clojure             | Java                                  | Description                                                                                |
|---------------------+---------------------------------------+--------------------------------------------------------------------------------------------|
| get-in m [keys]     | CountPair getCount(subj, action, obj) | Directly access a leaf                                                                     |
| (vals (get m subj)) | recordsByInteraction(subject)   | |
|                    | sortedRecordsByInteraction(subject)                 | |
|                     | sumCounts(subject)                    | Sum all event counts for one subject                                                       |
|                     | sumCounts(subject, action...)         | For a given subject,<br>sum all event counts for a set of actions,                         |


## License

Copyright © 2015 Michael Richards

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
