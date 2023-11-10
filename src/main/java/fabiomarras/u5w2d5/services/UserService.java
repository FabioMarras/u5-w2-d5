package fabiomarras.u5w2d5.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import fabiomarras.u5w2d5.entities.Dispositivo;
import fabiomarras.u5w2d5.entities.User;
import fabiomarras.u5w2d5.exceptions.NotFoundException;
import fabiomarras.u5w2d5.exceptions.SameIdException;
import fabiomarras.u5w2d5.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @Autowired
    private Cloudinary cloudinary;

    //GET /user per avere una la lista degli user
        public Page<User> getAllUser(int page, int size, String orderBy){
            Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
            return userRepository.findAll(pageable);
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
            user.setAvatar(body.getAvatar());
            user.setDispositivo(body.getDispositivo());
            return userRepository.save(user);
    }

    //DELETE /user/id - cancella uno user specifido dal suo id
    public void findByIdAndDelete(int id){
            User user = this.findById(id);{
                userRepository.delete(user);
        }
    }

    //UPLOAD DI IMMAGINI
    public String uploadImage(MultipartFile file) throws IOException{
            return (String) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
    }

}

