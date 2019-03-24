# Generate the graph

# graph=graph_from_data_frame(edges,directed = F)
load ("/home/derrick/Documents/9code/nis/netintel/Netzgraphen/TRA5")
# .RData files were written with an older version of the igraph package
graph = upgrade_graph (teilnetzgraph)

# Plot the graph
plot.igraph(graph,vertex.label.cex=0.8)
#   Calculate the distance of all vertices to the busbar in the station
distMatrix = shortest.paths(graph, v = "SAM21021", to = V(graph), weights=E(graph)$Leitungslaenge)
# Connect the vertices with the distance-attribute
V(graph)$distance = as.numeric(distMatrix[1,])
# Get a data.frame of all vertices
vertices = as_data_frame(graph, what="vertices")
# Identify all "Abgaenge" in the station (they can be identified by their distance of 0.0001 km)
abgaenge=vertices[vertices$distance<=0.000100 & substr(vertices$name,1,3)=="ABG",]
# Data.frame for saving the results
alldirecthas=data.frame()
#For each Hausanschluss
for(has in vertices[substr(vertices$name,1,3)=="HAS","name"])
{
    # Get all connected edges
    con_edges = E(graph)[adj(has)]
    # If there is more than one connected edge -> next
    if(length(con_edges)>1)
        next
    else
    {
        # Get all connected vertices
        con_vertices = as.data.frame(V(graph)[adj(con_edges)]$name)
        names(con_vertices)="name"
        # Get only the unkown vertex (has is known)
        con_vertices=as.character(con_vertices[con_vertices$name!=has,])
        # If con_vertices is one of the abgaenge in the station -> remember the has and the length of its connection line
        if(nrow(abgaenge[abgaenge$name==con_vertices,])==1)
        {
            directhas=data.frame(has,vertices[vertices$name==has,"distance"]-0.0001)
            names(directhas)=c("name","distance")
            alldirecthas=rbind(alldirecthas,directhas)
        }  
    }
}
# Calculate the mean of all direct house connections
mean(alldirecthas$distance)
