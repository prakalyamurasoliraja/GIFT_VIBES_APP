// Login.jsx
import React from "react";
import loginImg from "../../login.svg";
import "./styles.css";
import { Link } from "react-router-dom";

function Login() {
  return (
    <div className="base-container">
      <div className="header">Login</div>
      <div className="content">
        <div className="image">
          <img src={loginImg} alt="img" />
        </div>
        <div className="form">
          <div className="form-group">
            <label htmlFor="username">Username</label>
            <input type="text" name="username" placeholder="username" />
          </div>
          <div className="form-group">
            <label htmlFor="password">Password</label>
            <input type="password" name="password" placeholder="password" />
          </div>
        </div>
      </div>
      <div className="footer">
        <Link to="/abcd" type="button" className="btn">
          Login
        </Link>
      </div>
    </div>
  );
}

export default Login;
