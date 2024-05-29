package Resources;

        import com.example.commentarys;
        import Services.Icommentaryservice;
        import com.example.commentarys;
        import Services.Icommentaryservice;
        import jakarta.inject.Inject;
        import jakarta.ws.rs.*;
        import jakarta.ws.rs.core.MediaType;
        import jakarta.ws.rs.core.Response;
        import java.util.List;

@Path("/Comentario")
public class ComentarioResource {

    @Inject
    Icommentaryservice comentarioService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getComentario(@PathParam("id") Long id) {
        commentarys comentario = comentarioService.findById(id);
        if (comentario == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Comentario no encontrado").build();
        }
        return Response.ok(comentario).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<commentarys> getComentarios() {
        return comentarioService.findAll();
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createComentario(commentarys comentarioRequest) {
        try {
            comentarioService.save(comentarioRequest);
            return Response.ok("Comentario guardado: " + comentarioRequest).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity("Error al guardar el comentario").build();
        }
    }

    @GET
    @Path("/paginated")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@QueryParam("page") @DefaultValue("1") int page) {
        try {
            int pageSize = 10;  // Tamaño de la página
            List<commentarys> comentarios = comentarioService.findPaginated(page, pageSize);
            return Response.ok(comentarios).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al obtener los comentarios paginados").build();
        }
    }
}
