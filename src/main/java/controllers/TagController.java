package controllers;

import api.ReceiptResponse;
import api.TagResponse;
import dao.TagsDao;
import generated.tables.records.ReceiptsRecord;
import generated.tables.records.TagRecord;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Path("")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TagController {
    final TagsDao tags;

    public TagController(TagsDao tags) {
        this.tags = tags;
    }

    @PUT
    @Path("/tags/{tag}")
    public void toggleTag(String body, @PathParam("tag") String tagName) {
        tags.insert(Integer.parseInt(body), tagName);
        // <your code here
    }
    @GET
    @Path("/tags/{tag}")
    public List<ReceiptResponse> getReceipts(@PathParam("tag") String tag) {
        List<ReceiptsRecord> receiptRecords = tags.getReceipts(tag);
        return receiptRecords.stream().map(ReceiptResponse::new).collect(toList());
    }
    @GET
    @Path("/gettags")
    public List<TagResponse> getTags() {
        List<TagRecord> TagRecords = tags.getAllTags();
        return TagRecords.stream().map(TagResponse::new).collect(toList());
    }
}


