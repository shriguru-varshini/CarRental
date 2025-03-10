import React, { useState } from "react";
import userService from "../../service/userService";

const DeleteUser = () => {
    const [credentials, setCredentials] = useState({
        email: "",
        password: "",
    });
    const [message, setMessage] = useState("");

    const handleChange = (e) => {
        setCredentials({ ...credentials, [e.target.name]: e.target.value });
    };

    const handleDelete = async (e) => {
        e.preventDefault();
        setMessage("");

        try {
            // Step 1: Authenticate user to get user ID
            const userData = await userService.login(credentials.email, credentials.password);
            
            if (!userData || !userData.id) {
                setMessage("Invalid email or password. Please try again.");
                return;
            }

            const userId = userData.id;

            // Step 2: Delete the user using the obtained user ID
            const isDeleted = await userService.deleteUser(userId);

            if (isDeleted) {
                setMessage("User deleted successfully.");
            } else {
                setMessage("Failed to delete user.");
            }
        } catch (error) {
            setMessage("An error occurred. Please try again.");
        }
    };

    return (
        <div>
            <h2>Delete Account</h2>
            {message && <p style={{ color: message.includes("successfully") ? "green" : "red" }}>{message}</p>}
            <form onSubmit={handleDelete}>
                <div>
                    <label>Email:</label>
                    <input type="email" name="email" value={credentials.email} onChange={handleChange} required />
                </div>
                <div>
                    <label>Password:</label>
                    <input type="password" name="password" value={credentials.password} onChange={handleChange} required />
                </div>
                <button type="submit">Delete Account</button>
            </form>
        </div>
    );
};

export default DeleteUser;
