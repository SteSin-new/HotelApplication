# PostgreSQL Docker Setup Guide

## Prerequisites

- Docker installed and running on your system

## Important Notes

> **⚠️ Port Conflict:** PostgreSQL uses port `5432` by default. If you already have PostgreSQL running, you'll need to use an alternative port (e.g., `5430`) to avoid conflicts.

> **🔑 Security:** Change the default password in the script if needed for security purposes.

---

## Docker Flag Reference

| Flag | Meaning | Purpose |
|------|---------|---------|
| `--rm` | Remove | Automatically remove container when stopped/exited |
| `-e` | Environment | Set environment variables (password, user, database, etc.) |
| `-d` | Detach | Run container in background |
| `-p` | Port | Map ports (host:container) |
| `-v` | Volume | Mount persistent storage volume |
| `--name` | Name | Assign a name to the container |

---

## Setup Instructions

### Step 1: Create the Setup Script

Create a file named `postgres-docker-setup.sh`:

```bash
#!/usr/bin/env bash

set -euo pipefail

mkdir -p "$HOME"/.local/docker/postgresql

docker run --rm \
  --name pg-docker \
  -e POSTGRES_PASSWORD=******* \
  -e POSTGRES_DB=local \
  -d \
  -p 5430:5432 \
  -e PGDATA=/var/lib/postgresql/data/pgdata \
  -v "$HOME"/.local/docker/postgresql/data:/var/lib/postgresql/data \
  postgres
```

### Step 2: Make the Script Executable

Check current permissions:
```bash
ls -l postgres-docker-setup.sh
```

Make it executable:
```bash
chmod a+x postgres-docker-setup.sh
```

### Step 3: Run the Script

```bash
./postgres-docker-setup.sh
```

---

## Connection Details

| Property | Value     |
|----------|-----------|
| **Host** | localhost |
| **Port** | 5430      |
| **Database** | local     |
| **Username** | postgres  |
| **Password** | *******   |

---

## Useful Docker Commands

### Check if container is running
```bash
docker ps | grep pg-docker
```

### View container logs
```bash
docker logs pg-docker
```

### Stop the container
```bash
docker stop pg-docker
```

### Remove persistent data (optional)
```bash
rm -rf "$HOME"/.local/docker/postgresql/data
```
