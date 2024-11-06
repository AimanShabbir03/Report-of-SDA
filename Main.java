/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author user
 */
import java.util.HashMap;
import java.util.Map;
class Post {
    private Long id;
    private String title;
    private String content;
    private String author;

    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }
}

class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    public void createPost(String title, String content, String author) {
        Post post = new Post(title, content, author);
        boolean isCreated = postService.createPost(post);
        if (isCreated) {
            System.out.println("Post created successfully.");
        } else {
            System.out.println("Failed to create post.");
        }
    }
}

class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public boolean createPost(Post post) {
        if (isValidPost(post)) {
            return postRepository.save(post);
        }
        return false;
    }

    private boolean isValidPost(Post post) {
        // Basic validation logic
        return post.getTitle() != null && !post.getTitle().isEmpty()
                && post.getContent() != null && !post.getContent().isEmpty()
                && post.getAuthor() != null && !post.getAuthor().isEmpty();
    }
}


class PostRepository {
    private final Map<Long, Post> database = new HashMap<>();
    private Long idCounter = 1L;

    public boolean save(Post post) {
        post.setId(idCounter++);
        database.put(post.getId(), post);
        System.out.println("Post saved with ID: " + post.getId());
        return true;
    }

    public Post findById(Long id) {
        return database.get(id);
    }
}

public class Main {
    public static void main(String[] args) {
        PostRepository postRepository = new PostRepository();
        PostService postService = new PostService(postRepository);
        PostController postController = new PostController(postService);

        postController.createPost("Sample Title", "This is the content of the post.", "Author Name");
    }
}
