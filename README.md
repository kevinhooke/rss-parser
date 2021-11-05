# rss-parser
Parses RSS feeds using Jackson XML. Extracts headlines from the feed and returns them as a data structure
representing the content of the feed:

Rss
- Channel
  - List<Item>
    - title
    - link
    - description
