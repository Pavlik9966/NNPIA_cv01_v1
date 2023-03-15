package com.nnpia.cv01.controllers;

import com.nnpia.cv01.domains.AppUser;
import com.nnpia.cv01.dtos.AppUserInputQLDTO;
import com.nnpia.cv01.services.AppUserService;
import com.nnpia.cv01.services.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

/*
 * The N+1 problem is a performance issue that occurs in relational databases when using
 * Object-Relational Mapping (ORM). It involves executing an initial query on the main table
 * and then executing additional queries for each row in the main table to obtain additional information.
 * This can lead to high database load and slow data processing.
 *
 * @BatchMapping is an annotation that efficiently retrieves data from the database using a single query.
 * This reduces the number of database queries and leads to more efficient data processing.
 *
 * @SchemaMapping maps the results of a custom SQL query to entity objects, while @BatchMapping retrieves data
 * from multiple entities with a single query, reducing the number of database queries and increasing performance.
 *
 * To use these annotations properly, they must be correctly imported, placed on the annotated method with
 * the correct parameters and return type, and in the case of @SchemaMapping, the query must be correctly written
 * and mapped to entities. In the case of @BatchMapping, entities and their relationships must be correctly defined
 * to enable efficient batch retrieval of data.
 * */

/*
 * GraphQL subscription is a feature of the GraphQL query language that allows real-time communication between
 * the client and the server. It enables the client to receive updates from the server whenever there is a change
 * in the data.
 *
 * a) In GraphQL subscription, the client initiates a connection with the server using a WebSocket protocol.
 * Once the connection is established, the client sends a subscription query to the server, which specifies the data
 * it wants to receive updates on. The server then sends the data to the client whenever there is a change in it.
 * In this way, the server acts as the sender, and the client acts as the receiver of the data.
 *
 * b) @SubscriptionMapping
 *
 * c) Real-time chat application: With GraphQL subscription, you can subscribe to a specific chat room and receive
 *                                real-time updates as new messages are sent by other users.
 * Real-time stock market tracker: A GraphQL subscription can be used to subscribe to a specific stock symbol and
 *                                 receive real-time updates as the stock price changes.
 *
 * d) A web socket is a two-way communication protocol that enables real-time communication between a client and
 * a server. It allows the server to push data to the client without the client having to explicitly request it.
 * GraphQL subscription uses web sockets to establish a persistent connection between the client and server, which
 * allows the server to push updates to the client in real-time as they become available.
 * */

@Controller
@RequiredArgsConstructor
public class AppUserQLController {
    private final AppUserService appUserService;

    public AppUser getAppUser(@Argument final Long id) throws ResourceNotFoundException {
        return appUserService.findUserById(id);
    }

    @MutationMapping
    public AppUser createAppUser(@Argument AppUserInputQLDTO appUserInputQLDTO) {
        return appUserService.createUser(appUserInputQLDTO.toEntity());
    }
}