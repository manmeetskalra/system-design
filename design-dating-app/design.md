# Design Dating App as a Microservice

## Before starting:

When designing a system, if I would have to start, I would think:

- The first step is to think what kind of features, I am gonna provide the user with this app.
- Probably then, I'll move onto architecture and other things

## Features:

Lets say the features, that I think users will like to have is:

- Storing profiles
  - Profiles will have some textual fields
  - Also, it can have images (Max: 5)
- Recommending matches
  - Discuss - how many active users?
  - lets say matc some percentage for
- After matching
  - Store matches
  -
- Chatbox with matches

## Profile Feature:

- Storing profile details
- Storing Images
  - It is kinda tedious process. Now lets discuss, how can we store images
  - Should we store as a File or Blob (Binary large objects)
    - Images are large in size and can not store as varchar
    - Images can be stored in DBs as Blob. If stored in DBs, what will be the benefits:
      - Mutability: Not necessary for us in case of images, as if we ever change image, we will not update the binary object of an image. Rather we will update it with a complete new image
      - Transaction properties: Not required by an image. As we will not be doing atomic changes to image
      - Indexes: Allow us to sort data, which help us find element faster. But for image, we will not be sorting binary
      - Access Control: It can get tedious
    - Good things about having file system:
      - Cheaper
      - Built for storing a file, so it is faster
      - Files are static, so we can have CDN for fast access
      - We will still have a db that will store - profile_id, image_id and image_url. image_url will be location for a distributed file system, for above benefits

## Basic System Design:

We have our client application, gateway service, Profile service

- Client Application

  - Send user authentication credentials(like username and tokens) to get access
  - Client will talk to the Gateway Service
  - Once authenticated, user can request to update profile
  - client can ask gateway service to

- Gateway Service:

  - The purpose of this service is to take request, authenticate the request with our authentication service and then redirect it to the respective service

- Profile Service

  - Authenticates user

- Image Service

  - lets have a separate service for images, so that we can have this service for any specific computation that requires images for ex - machine learning models etc.

- Matcher Service:

  - information to store is likes, matches etc
  - we can store this information in client or server. We can store few information to store in client and others in server based on the importance of the information
  - Lets say, we store likes in client and matches in a new service called `Matcher Service`
  - `Matcher Service` will store matches in server and has a table that maps `user_id` to `user_id`
  - Matcher Service will check if you're match with a specific `user_id` and then also update `Session Service` that you can send message to a specific `user_id`
  -

- Chat Service:
  - To have chat, we will need XMPP(peer to peer) protocol
    - we don't wanna use http because its a client - server protocol. In this if we need chat, both the clients will have to run a repititive job to ask server if it has received any message for me or not, which is not at all efficient
  - Internally, the XMPP connection will have web sockets (read)
  - With every new chat_id, we will have an attached user_id that can be stored in another service that can handle sessions called `Sessions Service` which will store connection information in a different table.
  - When a message is sent, it first goes to `Matcher Service` for authentication and then redirected to `Sessions Service` which then sends it to the `user_id` where the message is needed to be sent

## Note:

If the app is uninstalled, the only information we lose is likes sent which holds less priority. All the matches can be pulled from `Matcher Service` and chats from `Session Service` and profile from `Profile Service`

## Recommendation feature:

- `Profile Service` holds on some other information like age, gender and location
- We can use these information for recommendation
- For recommendation, we might need a distributed database like Cassandra or Dynamo DB
  - these kind of dbs are very good in querying in large dbs like
- We can also have relational db but we will need to shard data or horizontal partitioning (Can be a little complicated than Cassandra)
  - for SPOF, we can have master-slave architecture for databases
  - Why do we need Sharding?
    - We can shard data based on location and then can be searched within a range of age and specific gender
- We will have a specific service for all of the above in a service called `Recommendation Service`
  - It pulls out all relevant peoples within the specific filters like range, age and gender
  - Reload the data, filter it every few seconds
