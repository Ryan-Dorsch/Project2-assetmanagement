package com.revature.pms.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.pms.model.Pokemon;
import com.revature.pms.model.Users;
import com.revature.pms.repo.PokemonRepository;
import com.revature.pms.repo.UsersRepository;

@Service(value = "usersService")
public class UsersServiceImpl implements  UserDetailsService, UsersService {

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	PokemonRepository pokemonRepository;

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

	@Override
	public Users findById(int id) {
		// TODO Auto-generated method stub
		return usersRepository.findById(id).get();
	}

	@Override
	public void addUsers(Users users) {
		// TODO Auto-generated method stub
		usersRepository.save(users);
	}

	@Override
	public void updateUsers(int id, Users users) {
		// TODO Auto-generated method stub
		usersRepository.save(users);
	}

	@Override
	public void deleteUsers(int id) {
		// TODO Auto-generated method stub
		usersRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		usersRepository.deleteAll();
	}
	
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        Users user = usersRepository.findByUsername(username)
                .orElseThrow(() -> 
                        new UsernameNotFoundException("User not found with username or email : " + username)
        );

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(Users user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        //String role = "Role_" + user.getRole().getName();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName().toString()));
        return authorities;
    }
	
	@Override
    public Users findOne(String username) {
        return usersRepository.findByUsername(username).get();
    }

	@Override
	public List<Pokemon> findAllPokemon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUserPokemon() {
		// TODO Auto-generated method stub
		
	}

}




