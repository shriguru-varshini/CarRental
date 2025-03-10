import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import userService from "../../service/userService";

const UpdateUser = () => {
    let id = 15;
    // const { id } = useParams(); // Get user ID from URL params
    const [user, setUser] = useState({
        name: "",
        email: "",
        phone: "",
        password: "",
    });
    const [error, setError] = useState("");

    useEffect(() => {
        const fetchUser = async () => {
            const data = await userService.getUserById(id);
            if (data) {
                setUser({
                    name: data.name,
                    email: data.email,
                    phone: data.phone,
                    password: "", // Keeping password blank for security
                });
            } else {
                setError("User not found");
            }
        };
        fetchUser();
    }, [id]);

    const handleChange = (e) => {
        setUser({ ...user, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError("");

        const response = await userService.updateUser(id, user);
        if (response) {
            alert("User updated successfully");
        } else {
            setError("Failed to update user");
        }
    };

    return (
        <div>
            <h2>Update User</h2>
            {error && <p style={{ color: "red" }}>{error}</p>}
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Name:</label>
                    <input type="text" name="name" value={user.name} onChange={handleChange} required />
                </div>
                <div>
                    <label>Email:</label>
                    <input type="email" name="email" value={user.email} onChange={handleChange} required />
                </div>
                <div>
                    <label>Phone:</label>
                    <input type="text" name="phone" value={user.phone} onChange={handleChange} required />
                </div>
                <div>
                    <label>Password:</label>
                    <input type="password" name="password" value={user.password} onChange={handleChange} />
                </div>
                <button type="submit">Update User</button>
            </form>
        </div>
    );
};

export default UpdateUser;
