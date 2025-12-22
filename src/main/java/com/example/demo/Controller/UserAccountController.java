@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping
    public UserAccount create(@RequestBody UserAccount user) {
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    public UserAccount get(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PutMapping("/{id}/status")
    public UserAccount updateStatus(@PathVariable Long id,
                                    @RequestParam String status) {
        return service.updateUserStatus(id, status);
    }

    @GetMapping
    public List<UserAccount> getAll() {
        return service.getAllUsers();
    }
}
