document.getElementById('loginForm')?.addEventListener('submit', async (e) => {
    e.preventDefault();
    const email = e.target.querySelector('input[type="email"]').value;
    const password = e.target.querySelector('input[type="password"]').value;
    const response = await fetch('/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, password })
    });
    if (response.ok) {
        const token = await response.text();
        localStorage.setItem('token', token);
        window.location.href = 'index.html';
    } else {
        alert('Login failed. Please try again.');
    }
});

document.getElementById('registerForm')?.addEventListener('submit', async (e) => {
    e.preventDefault();
    const name = e.target.querySelector('input[type="text"]').value;
    const email = e.target.querySelector('input[type="email"]').value;
    const password = e.target.querySelector('input[type="password"]').value;
    const confirmPassword = document.getElementById('confirmPassword').value;

    if (password !== confirmPassword) {
        alert('Passwords do not match. Please try again.');
        return;
    }

    const response = await fetch('/auth/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name, email, password })
    });
    if (response.ok) {
        window.location.href = 'login.html';
    } else {
        alert('Registration failed. Please try again.');
    }
});

function requestSkill(name) {
    alert(`Swap request sent to ${name}`);
    // Add API call to /swaps with token
}

function changePage(direction) {
    alert(`Page changed by ${direction}`);
    // Add API call to fetch paginated users
}