### About

Spring web application, which consumes audio tags via kafka, and persist them in a database. The database is accessible thought REST endpoints.
The tags could be paired with tracks on spotify, which is done by another consumer.

### Build

- Run `docker-compose up` for database

### Environment variables

| Name                                      | Format   | Default value                                      | Comment                                                    |
|-------------------------------------------|----------|----------------------------------------------------|------------------------------------------------------------|
| `KAFKA_AUDIO_TAG_TOPIC`                   | string   |                                                    |  |
| `KAFKA_SERVER`                            | string   |                                                    |  |
| `KAFKA_SPOTIFY_TRACK_TOPIC`               | string   |                                                    |  |
| `KAFKA_TRACK_LIKED_TOPIC`                 | string   |                                                    |  |
| `KAFKA_PLAYLIST_CREATED_TOPIC`            | string   |                                                    |  |
| `DATASOURCE_USERNAME`                     | string   | mozeshajdu                                         |  |
| `DATASOURCE_PASSWORD`                     | string   | mozeshajdu                                         |  |
| `DATASOURCE_URL`                          | string   | jdbc:postgresql://localhost:5432/audiotag          |  |
| `HIBERNATE_DDL_AUTO`                      | string   | update                                             | Options: validate, update, create, create-drop, none  |
| `SHOW_SQL`                                | string   | false                                              | Show sql queries on console. Only use it for development|