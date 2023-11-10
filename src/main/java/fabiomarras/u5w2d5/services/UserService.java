package fabiomarras.u5w2d5.services;

import fabiomarras.u5w2d5.entities.User;
import fabiomarras.u5w2d5.exceptions.NotFoundException;
import fabiomarras.u5w2d5.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //GET /user
    //GET /user/id
    //POST /user - crea uno user
    //PUT /user/id - modifica uno user
    //DELETE /user/id - cancella uno user

    @Autowired
    private UserRepository userRepository;

    //GET /user per avere una la lista degli user
        public List<User> getAllUser(int page, int size, String orderBy){
            Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
            return userRepository.findAll();
        }

    //GET /user/id ricerca per specifico id
    public User findById(int id){
            return userRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    //POST /user - crea uno user
    public User save(User body){
            return userRepository.save(body);
    }

    //PUT /user/id - modifica uno user specifico
    public User findByIdAndUpdate(int id, User body){
            User user = this.findById(id);
            user.setUsername(body.getUsername());
            user.setName(body.getName());
            user.setLastName(body.getLastName());
            user.setEmail(body.getEmail());
            return userRepository.save(user);
    }


    //DELETE /user/id - cancella uno user specifido dal suo id
    public void findByIdAndDelete(int id){
            User user = this.findById(id);{
                userRepository.delete(user);
        }
    }


}

