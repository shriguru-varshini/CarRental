import React, { useState } from "react";
import userService from "../../service/userService";

const FindByEmail = () => {
    const [email, setEmail] = useState("");
    const [user, setUser] = useState(null);
    const [error, setError] = useState("");

    const handleChange = (e) => {
        setEmail(e.target.value);
    };

    const handleSearch = async (e) => {
        e.preventDefault();
        setError("");
        setUser(null);

        try {
            const response = await userService.getUserByEmail(email);
            if (response) {
                setUser(response);
            } else {
                setError("No user found with this email.");
            }
        } catch (err) {
            setError("Something went wrong. Please try again.");
            console.error("Error fetching user:", err);
        }
    };

    return (
        <div>
            <h2>Find User by Email</h2>
            {error && <p style={{ color: "red" }}>{error}</p>}
            <form onSubmit={handleSearch}>
                <label>Email:</label>
                <input type="email" value={email} onChange={handleChange} required />
                <button type="submit">Search</button>
            </form>

            {user && (
                <div>
                    <h3>User Details</h3>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Created At</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>{user.id}</td>
                                <td>{user.name}</td>
                                <td>{user.email}</td>
                                <td>{user.phone}</td>
                                <td>{new Date(user.createdAt).toLocaleString()}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            )}
        </div>
    );
};

export default FindByEmail;
